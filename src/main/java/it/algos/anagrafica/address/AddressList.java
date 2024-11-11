package it.algos.anagrafica.address;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import it.algos.vbase.annotation.IList;
import it.algos.vbase.components.SimpleVerticalLayout;
import it.algos.vbase.list.AList;
import it.algos.vbase.ui.wrapper.ASpan;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@SpringComponent
@Scope(value = SCOPE_PROTOTYPE)
@IList()
public class AddressList extends AList {


    /**
     * Costruttore invocato dalla sottoclasse concreta obbligatoriamente con un parametro <br>
     * Mantiene il riferimento ad una istanza prototype della CrudView <br>
     */
    public AddressList(final AddressView parentCrudView) {
        super(parentCrudView);
    }


//    protected void fixPreferenze() {
//
//        this.usaBottoneResetDelete = true;
//        this.usaBottoneResetAdd = false;
//    }

    @Override
    public void fixHeader() {
        VerticalLayout layout = new SimpleVerticalLayout();
        layout.add(ASpan.text("Blocco per l'indirizzo utilizzabile in anagrafica.").verde());
        layout.add(ASpan.text("Tavola esemplicativa. La singola entity rimane all'interno di Persone.").rosso().small());
        headerPlaceHolder.add(layout);

        super.fixHeader();
    }

}// end of AList class
