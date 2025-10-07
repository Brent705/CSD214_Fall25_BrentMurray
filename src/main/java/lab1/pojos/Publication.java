package lab1.pojos;

import java.io.Serializable;

public abstract class Publication extends Editable implements SaleableItem, Serializable {
    private String title;
    private int copies;
}
