package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.v3.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean support(Object handler) {
        return handler instanceof ControllerV4;
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controllerV4 = (ControllerV4) handler;
        Map<String, String> paramMap = paramMap(request);

        Map<String, Object> model = new HashMap<>();
        String viewName = controllerV4.process(paramMap, model);
        ModelView mv = new ModelView(viewName);
        mv.setModel(model);  // Adpater 기능 : 직접 ModelView 를 만들어서, viewName 을 return 하는 ControllerV4 가 동작할  수 있도록 해준다.
        return mv;
    }

    private Map<String, String> paramMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
