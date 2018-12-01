package shipping;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingController {

    private static final String template = "Shipping %s";
    private final AtomicLong counter = new AtomicLong();
    private final String[] status = new String[]{"shipped", "processing"};
    private final String[] items = new String[]{
            "Samsung Galaxy S9 Plus", "Huawei MateBook X Pro",
            "Nikon D850", "Apple Watch 4", "Go Pro Hero06",
            "Google Pixel Slate", "Lenovo Chromebook C330"};

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/shipping")
    public Shipping shipping(@RequestParam(value = "id") long orderId) {
        String orderStatus = status[new Random().nextInt(status.length)];
        String item = items[new Random().nextInt(items.length)];
        return new Shipping(orderId, item, orderStatus);
    }
}
