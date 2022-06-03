package com.pfe.pfe.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "files")
@Data @NoArgsConstructor
public class DBFile  {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String fileName;

    private String fileType;

    //LOB or Large OBject refers to a variable length datatype for storing large objects.
    @Lob
    private byte[] data;



    public DBFile(String id,String fileName, String fileType, byte[] data) {
        super();
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }


}