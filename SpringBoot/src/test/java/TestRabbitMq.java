import com.rabbitMq.RabbitMqApplication;
import com.rabbitMq.producer.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = RabbitMqApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRabbitMq {

    @Autowired
    private ProducerService producerService;

    @Test
    public void testRabbitMq(){
        producerService.producer("xxx");
    }
}
