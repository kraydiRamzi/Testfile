package com.pfe.pfe.Repository;

import com.pfe.pfe.Model.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepo extends JpaRepository <DBFile, String> {

}
