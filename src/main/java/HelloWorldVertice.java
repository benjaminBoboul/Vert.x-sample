import io.vertx.core.*;

public class HelloWorldVertice extends AbstractVerticle {
    @Override
    public void start(Future<Void> future) throws Exception {
        vertx
                .createHttpServer()
                .requestHandler(r -> {
                    r.response().end("<h1>Hello, world</h1>");
                })
                .listen(8080, result -> {
                    if (result.succeeded()) future.complete();
                    else future.fail(result.cause());
                });
    }
}
