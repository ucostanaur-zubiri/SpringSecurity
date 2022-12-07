package eus.hekuntza.zubiri.controllers;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cors")
public class CORSTest {
  private Logger logger = Logger.getLogger(CORSTest.class.getName());

  @GetMapping("/")
  public String main() {
    return "corstest.html";
  }

  @CrossOrigin(origins = {"http://127.0.0.1:8080", "http://localhost:8080"})
  @PostMapping("/test")
  @ResponseBody
  public String test() {
    logger.info("Test method called");
    System.out.println("Test method called");
    return "HELLO";
  }

}
