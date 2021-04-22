package com.github.splos.comment;

import com.github.splos.car.Car;
import com.github.splos.car.CarRepository;
import com.github.splos.user.User;
import com.github.splos.user.UserRepository;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/comment/car")
public class CommentController {

  private final UserRepository userRepository;
  private final CarRepository carRepository;
  private final CommentRepository commentRepository;

  public CommentController(UserRepository userRepository,
      CarRepository carRepository, CommentRepository commentRepository) {
    this.userRepository = userRepository;
    this.carRepository = carRepository;
    this.commentRepository = commentRepository;
  }

  @PostMapping("/{carId}")
  public Car comment(@PathVariable Long carId, @Valid @RequestBody CommentRequest commentRequest,
      Principal principal) {
    User user = this.userRepository.findByEmail(principal.getName()).orElse(null);
    Car car = this.carRepository.findById(carId).orElse(null);

    if (user == null || car == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    Comment comment = new Comment();
    comment.setComment(commentRequest.getComment());
    comment.setUser(user);
    comment.setCar(car);

    commentRepository.save(comment);

    return car;
  }
}
