import io.vertx.core.Vertx;

public class HelloWorldMain {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(HelloWorldVertice.class.getName());
    }
}
