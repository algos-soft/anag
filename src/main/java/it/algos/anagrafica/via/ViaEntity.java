package it.algos.anagrafica.via;

import it.algos.vbase.backend.annotation.*;
import it.algos.vbase.backend.entity.*;
import it.algos.vbase.backend.enumeration.*;
import lombok.*;
import org.springframework.data.mongodb.core.index.*;
import org.springframework.data.mongodb.core.mapping.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "via")
@AReset()
@AEntity()
public class ViaEntity extends AbstractEntity {

    @AFieldList(headerText = "#")
    @AField(type = TypeField.ordine)
    private int ordine;

    @Indexed(unique = true)
    @ASearch(type = TypeSearch.textStartsWith)
    @AFieldList(headerText = "Nome")
    @AFieldForm(label = "Nome")
    @AField(type = TypeField.text)
    private String code;

    @Override
    public String toString() {
        return code;
    }

}// end of Entity class
