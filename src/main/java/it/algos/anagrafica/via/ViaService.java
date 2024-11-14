package it.algos.anagrafica.via;

import it.algos.vbase.boot.BaseCost;
import it.algos.vbase.enumeration.RisultatoReset;
import it.algos.vbase.enumeration.TypeLog;
import it.algos.vbase.logic.ModuloService;
import it.algos.vbase.service.ResourceService;
import it.algos.vbase.wrapper.WrapLog;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project base24
 * Created by Algos
 * User: gac
 * Date: mer, 25-ott-2023
 * Time: 07:46
 */
@Service
public class ViaService extends ModuloService<ViaEntity> {

    private static final String KEY_NAME = BaseCost.FIELD_NAME_CODE;

    @Autowired
    private ResourceService resourceService;

    private Map<String, ViaEntity> mappaBeans= new HashMap<>();

    /**
     * Regola la entityClazz associata a questo Modulo e la passa alla superclasse <br>
     * Regola la viewClazz @Route associata a questo Modulo e la passa alla superclasse <br>
     * Regola la listClazz associata a questo Modulo e la passa alla superclasse <br>
     */
    public ViaService() {
        super(ViaEntity.class);
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
    public ObjectId getObjectId(ViaEntity newEntityBean) {
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
            mappaBeans.values().stream().forEach(bean -> creaIfNotExists( bean));
            return RisultatoReset.vuotoMaCostruito;
        }
        else {
            message = String.format("Manca il file [%s] nella directory /config o sul server", nomeFileCSV);
            logger.warn(new WrapLog().message(message).type(TypeLog.startup));
            return RisultatoReset.nonCostruito;
        }
    }


}// end of CrudService class
