package com.Rb.Service;

import com.Rb.model.Reject;

import java.util.List;

public interface RejectService {
    Reject Save(Reject reject);

    List getAll();
}
