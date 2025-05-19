package com.brainqy.master.repos;

import com.brainqy.master.entities.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {
}
