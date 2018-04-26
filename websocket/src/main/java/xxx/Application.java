package xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import xxx.websocket.ChatRoomServerEndpoint;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableWebSocket
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    public ChatRoomServerEndpoint chatRoomServerEndpoint() {
        return new ChatRoomServerEndpoint();
    }

}
