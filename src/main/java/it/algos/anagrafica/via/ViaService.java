package it.algos.anagrafica.via;

import it.algos.anagrafica.via.*;
import it.algos.vbase.backend.boot.*;
import it.algos.vbase.backend.entity.*;
import it.algos.vbase.backend.enumeration.*;
import it.algos.vbase.backend.logic.*;
import it.algos.vbase.backend.service.*;
import it.algos.vbase.backend.wrapper.*;
import org.bson.types.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Project base24
 * Created by Algos
 * User: gac
 * Date: mer, 25-ott-2023
 * Time: 07:46
 */
@Service
public class ViaService extends CrudCompanyService {

    private static final String KEY_NAME = BaseCost.FIELD_NAME_CODE;

    @Autowired
    private ResourceService resourceService;

    /**
     * Regola la entityClazz associata a questo Modulo e la passa alla superclasse <br>
     * Regola la viewClazz @Route associata a questo Modulo e la passa alla superclasse <br>
     * Regola la listClazz associata a questo Modulo e la passa alla superclasse <br>
     */
    public ViaService() {
        super(ViaEntity.class, ViaView.class);
    }


    /**
     * Creazione in memoria di una nuova entity che NON viene salvata <br>
     *
     * @param code (obbligatorio, unico)
     *
     * @return la nuova entity appena creata (con keyID ma non salvata)
     */
    public ViaEntity newEntity(final int ordine, final String code) {
        ViaEntity newEntityBean = new ViaEntity();

        newEntityBean.setOrdine(ordine == 0 ? nextOrdine() : ordine);
        newEntityBean.setCode(textService.isValid(code) ? code : null);

        return newEntityBean;
    }

    @Override
    public ObjectId getObjectId(AbstractEntity newEntityBean) {
        return super.getObjectId(((ViaEntity) newEntityBean).getCode());
    }

    @Override
    public ViaEntity findById(final String idStringValue) {
        return (ViaEntity) super.findById(idStringValue);
    }

    public ViaEntity findByKey(final String keyValue) {
        return (ViaEntity) super.findOneByProperty(KEY_NAME, keyValue);
    }


    @Override
    public List<ViaEntity> findAll() {
        return super.findAll();
    }


    public RisultatoReset reset() {
        String nomeFileCSV = "vie.csv";
        int pos = 0;
        String message;
        ViaEntity newBean;

        Map<String, List<String>> mappaSource = resourceService.leggeMappa(nomeFileCSV);
        if (mappaSource != null && mappaSource.size() > 0) {
            for (List<String> rigaUnValore : mappaSource.values()) {
                newBean = newEntity(++pos, rigaUnValore.get(0));
                mappaBeans.put(rigaUnValore.get(0), newBean);
            }
            mappaBeans.values().stream().forEach(bean -> creaIfNotExists((ViaEntity) bean));
            return RisultatoReset.vuotoMaCostruito;
        }
        else {
            message = String.format("Manca il file [%s] nella directory /config o sul server", nomeFileCSV);
            logger.warn(new WrapLog().message(message).type(TypeLog.startup));
            return RisultatoReset.nonCostruito;
        }
    }


}// end of CrudService class
