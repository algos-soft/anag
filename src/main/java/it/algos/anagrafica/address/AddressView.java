package it.algos.anagrafica.address;

import com.vaadin.flow.router.Route;
import it.algos.vbase.annotation.IView;
import it.algos.vbase.constant.Gruppo;
import it.algos.vbase.ui.view.AView;
import it.algos.vbase.ui.view.MainLayout;
import it.algos.wiki24.backend.modules.anno.AnnoWikiEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Project base24
 * Created by Algos
 * User: gac
 * Date: Thu, 01-Feb-2024
 * Time: 11:53
 *
 * @Route chiamata dal menu generale o dalla barra del browser <br>
 */
@Route(value = "address", layout = MainLayout.class)
@IView(menuAutomatico = false, menuGroup = Gruppo.UTILITY, menuName = "Address")
public class AddressView extends AView {


    AddressView(@Autowired AddressService moduloService) {
        super(AnnoWikiEntity.class, moduloService, AddressList.class, AddressForm.class);
    }

}// end of @Route CrudView class
