package View;

import Controller.Attribute;
import Model.Histogram;
import Model.Mail;
import java.util.List;

public class HistogramBuilder<T> {
    private final List<T> items;

    public HistogramBuilder(List<T> items) {
        this.items = items;
    }

    public <A>Histogram<A> buil(Attribute<T,A> attribute){
        Histogram<A> histo = new Histogram<>();
        for (T item : items) {
            A value = attribute.get(item);
            histo.increment(value);
        }
        
        return histo;
    }
    
}
