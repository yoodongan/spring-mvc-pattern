package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    // 파라미터로 model 을 넣어버리고, viewName 만 리턴한다.
    String process(Map<String, String> paramMap, Map<String, Object> model);

}
