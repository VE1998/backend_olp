package com.olpasa.service.impl;

import com.olpasa.model.Control_rff;
import com.olpasa.repo.IControlRffRepo;
import com.olpasa.service.IControlRffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlRffServiceImpl implements IControlRffService {

    @Autowired
    private IControlRffRepo controlRffRepo;
    @Override
    public Control_rff registrar(Control_rff controlRff) {
        return controlRffRepo.save(controlRff);
    }

    @Override
    public Control_rff modificar(Control_rff controlRff) {
        return controlRffRepo.save(controlRff);
    }

    @Override
    public Control_rff leerPorId(Integer id) {
        return controlRffRepo.findById(id).orElse(null);
    }

    @Override
    public List<Control_rff> listar() {
        return controlRffRepo.findAll();
    }

    @Override
    public void eliminar(Integer id) {

    }
}
