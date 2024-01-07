import com.app.AppConfig;
import com.app.AppRepository;
import com.app.AppService;
import com.app.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppRepository repo = context.getBean("appRepository", AppRepository.class);
        System.out.println(repo.save(new Person("Robot", "Japan")));

        AppService service = context.getBean(AppService.class);
        Person person = service.get();
        System.out.println(person);


    }
}
