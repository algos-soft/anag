package it.algos.anagrafica.address;

import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.spring.annotation.*;
import it.algos.vbase.backend.components.*;
import it.algos.vbase.backend.list.*;
import it.algos.vbase.ui.wrapper.*;
import static org.springframework.beans.factory.config.BeanDefinition.*;
import org.springframework.context.annotation.*;

@SpringComponent
@Scope(value = SCOPE_PROTOTYPE)
public class AddressList extends CrudList {


    /**
     * Costruttore invocato dalla sottoclasse concreta obbligatoriamente con un parametro <br>
     * Mantiene il riferimento ad una istanza prototype della CrudView <br>
     */
    public AddressList(final AddressView parentCrudView) {
        super(parentCrudView);
    }


    protected void fixPreferenze() {

        this.usaBottoneResetDelete = true;
        this.usaBottoneResetAdd = false;
    }

    @Override
    public void syncHeader() {
        VerticalLayout layout = new SimpleVerticalLayout();
        layout.add(ASpan.text("Blocco per l'indirizzo utilizzabile in anagrafica.").verde());
        layout.add(ASpan.text("Tavola esemplicativa. La singola entity rimane all'interno di Persone.").rosso().small());
        headerPlaceHolder.add(layout);

        super.fixHeaderPost();
    }

}// end of CrudList class
