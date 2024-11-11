package it.algos.anagrafica.via;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.spring.annotation.SpringComponent;
import it.algos.vbase.annotation.IList;
import it.algos.vbase.components.BAnchor;
import it.algos.vbase.list.AList;
import it.algos.vbase.ui.dialog.BSpan;
import org.springframework.context.annotation.Scope;

import static it.algos.vbase.boot.BaseCost.*;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@SpringComponent
@Scope(value = SCOPE_PROTOTYPE)
@IList()
public class ViaList extends AList {

    protected String infoCreazione;

    protected String infoReset;

    /**
     * @param parentCrudView che crea questa istanza
     */
    public ViaList(final ViaView parentCrudView) {
        super(parentCrudView);
    }


//    protected void fixPreferenze() {
//        super.fixPreferenze();
//
//        super.usaBottoneDeleteAll = true;
//        super.usaBottoneResetAdd = true;
//    }


    @Override
    protected void fixHeader() {
        String link = "vie";
        BAnchor anchor = BAnchor.build(LINK_SERVER_ALGOS + link, textService.setQuadre("algos -> " + link));
        BSpan testo = BSpan.text(TEXT_TAVOLA + SPAZIO + TEXT_CSV).bold().verde();
        headerPlaceHolder.add(new Span(testo, new Text(SPAZIO), anchor));

        super.infoScopo = VUOTA;
        infoCreazione = TEXT_NEWS;
        infoReset = TEXT_RESET_ADD;

        super.fixHeader();
    }


}// end of AList class
