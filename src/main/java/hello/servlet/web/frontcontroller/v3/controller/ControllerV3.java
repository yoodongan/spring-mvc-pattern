package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.v3.ModelView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap) throws ServletException, IOException;
}
