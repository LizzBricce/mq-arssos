package consumer;

import stock.Product;
import stock.Stock;

import java.util.concurrent.BlockingQueue;

public class Queue {
    private final BlockingQueue<Product> in;
    private final Stock stock;

    public Queue(BlockingQueue<Product> in) {
        this.in = in;
        stock = new Stock();
    }

    public BlockingQueue<Product> getIn() {
        return in;
    }

    public Stock getStock() {
        return stock;
    }

    public void start(){
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Product product = in.take();

                        stock.handleProduct(product);
                    } catch (InterruptedException ie) {

                    }
                }
            }
        }).start();
    }
}
