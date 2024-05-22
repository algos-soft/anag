package it.algos.anagrafica.via;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.spring.annotation.*;
import static it.algos.vbase.backend.boot.BaseCost.*;
import it.algos.vbase.backend.components.*;
import it.algos.vbase.backend.list.*;
import it.algos.vbase.ui.dialog.*;
import static org.springframework.beans.factory.config.BeanDefinition.*;
import org.springframework.context.annotation.*;

@SpringComponent
@Scope(value = SCOPE_PROTOTYPE)
public class ViaList extends CrudCompanyList {


    //--non utilizzato. Serve SOLO per evitare un bug di IntelliJIDEA che segnala errore.
    public ViaList() {
        super();
    }


    /**
     * @param parentCrudView che crea questa istanza
     */
    public ViaList(final ViaView parentCrudView) {
        super(parentCrudView);
    }



    protected void fixPreferenze() {
        super.fixPreferenze();

        super.usaBottoneDeleteAll = true;
        super.usaBottoneResetAdd = true;
        super.usaSelettoreColonne = true;
        super.setColonneLista("id", "ordine", "code");
    }



    @Override
    protected void syncHeader() {
        String link = "vie";
        BAnchor anchor = BAnchor.build(LINK_SERVER_ALGOS + link, textService.setQuadre("algos -> " + link));
        BSpan testo = BSpan.text(TEXT_TAVOLA + SPAZIO + TEXT_CSV).bold().verde();
        headerPlaceHolder.add(new Span(testo, new Text(SPAZIO), anchor));

        super.infoScopo = VUOTA;
        super.infoCreazione = TEXT_NEWS;
        super.infoReset = TEXT_RESET_ADD;

        super.fixHeaderPost();
    }


}// end of CrudList class
