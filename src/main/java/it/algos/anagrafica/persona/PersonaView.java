package it.algos.anagrafica.persona;

import com.vaadin.flow.router.Route;
import it.algos.vbase.annotation.IView;
import it.algos.vbase.constant.Gruppo;
import it.algos.vbase.ui.view.AView;
import it.algos.vbase.ui.view.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Project base24
 * Created by Algos
 * User: gac
 * Date: Thu, 01-Feb-2024
 * Time: 12:28
 *
 * @Route chiamata dal menu generale o dalla barra del browser <br>
 */
@Route(value = "persona", layout = MainLayout.class)
@IView(menuGroup = Gruppo.ANAG, menuName = "Persone")
public class PersonaView extends AView {


    PersonaView(@Autowired PersonaService moduloService) {
        super(PersonaEntity.class, moduloService, PersonaList.class, PersonaForm.class);
    }

}// end of @Route CrudView class
