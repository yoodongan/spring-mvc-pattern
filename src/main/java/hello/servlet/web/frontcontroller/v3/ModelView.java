package hello.servlet.web.frontcontroller.v3;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ModelView {
    private String viewName;  // 논리 view 명. (view 경로명 중복을 제거하기 위해서 사용한다.)
    private Map<String, Object> model = new HashMap<>(); //request.setAttribute(); 와 똑같은 기능 수행.

    public ModelView(String viewName) {
        this.viewName = viewName;
    }
}
