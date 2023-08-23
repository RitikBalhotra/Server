package com.Rb.Service;

import com.Rb.model.Accept;

import java.util.List;

public interface AcceptService {

    Accept Save(Accept accept);

    List getAll();
}
