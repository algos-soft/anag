package it.algos.anagrafica.address;

import it.algos.anagrafica.via.ViaEntity;
import it.algos.vbase.annotation.AEntity;
import it.algos.vbase.annotation.AFieldList;
import it.algos.vbase.annotation.AReset;
import it.algos.vbase.entity.AbstractEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "address")
@AReset()
@AEntity()
public class AddressEntity extends AbstractEntity {

    @DBRef
    @AFieldList(width = 8)
//    @AField(type = TypeField.linkDBRef, linkClazz = ViaEntity.class)
    private ViaEntity typeVia;

    @AFieldList(width = 14)
    private String indirizzo;

    @AFieldList(width = 18)
    private String localita;

    @AFieldList(width = 5)
    private String cap;

    @Override
    public String toString() {
        return indirizzo;
    }

}// end of Entity class
