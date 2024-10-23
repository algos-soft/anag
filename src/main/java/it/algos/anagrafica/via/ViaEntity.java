package it.algos.anagrafica.via;

import it.algos.vbase.annotation.*;
import it.algos.vbase.entity.AbstractEntity;
import it.algos.vbase.enumeration.TextSearchMode;
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
    private int ordine;

    @Indexed(unique = true)
    @ASearch(textSearchMode = TextSearchMode.startsWith)
    @AFieldList(headerText = "Nome")
    @AFieldForm(label = "Nome")
    private String code;

    @Override
    public String toString() {
        return code;
    }

}// end of Entity class
