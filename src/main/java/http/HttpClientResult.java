package http;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 封装httpClient响应结果
 *
 * @author Cao.Zhuang
 * @date 2019/10/18 16:40
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpClientResult implements Serializable {

    private static final long serialVersionUID = -7175446121112343485L;

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;

    public HttpClientResult(int code) {
        this.code = code;
    }

}
