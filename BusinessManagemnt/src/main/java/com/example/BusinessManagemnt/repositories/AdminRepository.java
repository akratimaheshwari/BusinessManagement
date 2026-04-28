package com.example.BusinessManagemnt.repositories;
import org.springframework.data.repository.CrudRepository;

import com.business.entities.Admin;
public interface AdminRepository extends CrudRepository<Admin, Integer>
{
    public Admin findByAdminEmail(String email);
}
