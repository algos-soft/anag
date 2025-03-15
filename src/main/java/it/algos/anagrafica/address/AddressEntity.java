package it.algos.anagrafica.address;

import it.algos.anagrafica.via.ViaEntity;
import it.algos.vbase.annotation.IEntity;
import it.algos.vbase.annotation.IFieldList;
import it.algos.vbase.annotation.IReset;
import it.algos.vbase.entity.AbstractEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "address")
@IReset()
@IEntity()
public class AddressEntity extends AbstractEntity {

    @DBRef
    @IFieldList(width = 8)
    private ViaEntity typeVia;

    @IFieldList(width = 14)
    private String indirizzo;

    @IFieldList(width = 18)
    private String localita;

    @IFieldList(width = 5)
    private String cap;

    @Override
    public String toString() {
        return indirizzo;
    }

}// end of Entity class
