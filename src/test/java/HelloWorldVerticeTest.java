import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(VertxUnitRunner.class)
public class HelloWorldVerticeTest {
    private Vertx vertx;
    @BeforeEach
    public void setUp(TestContext context) {
        vertx = Vertx.vertx();
        vertx.deployVerticle(HelloWorldVertice.class.getName(),
                context.asyncAssertSuccess());
    }
    @AfterEach
    public void tearDown(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }
    @Test
    public void testMyApplication(TestContext context) {
        final Async async = context.async();
        vertx.createHttpClient().getNow(8080, "localhost", "/",
                response -> {
                    response.handler(body -> {
                        context.assertTrue(body.toString().contains("Hello"));
                        async.complete();
                    });
                });
    }
}