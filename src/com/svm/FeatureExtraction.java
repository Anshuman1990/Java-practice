package com.svm;

public class FeatureExtraction {
    private Double _label;
    private Integer _classification;
    private Double _caseId;
    private Double _daysRemaining;
    private Double _normalizedValue;

    public Double get_normalizedValue() {
        return _normalizedValue;
    }

    public void set_normalizedValue(Double _normalizedValue) {
        this._normalizedValue = _normalizedValue;
    }


    public Double get_label() {
        return _label;
    }

    public void set_label(Double _label) {
        this._label = _label;
    }

    public Integer get_classification() {
        return _classification;
    }

    public void set_classification(Integer _classification) {
        this._classification = _classification;
    }

    public Double get_caseId() {
        return _caseId;
    }

    public void set_caseId(Double _caseId) {
        this._caseId = _caseId;
    }

    public Double get_daysRemaining() {
        return _daysRemaining;
    }

    public void set_daysRemaining(Double _daysRemaining) {
        this._daysRemaining = _daysRemaining;
    }

    @Override
    public String toString() {
        StringBuilder _sBuild = new StringBuilder();
        _sBuild.append("CaseId= " + this.get_caseId() + "\n");
        _sBuild.append("Days Remaining= " + this.get_daysRemaining() + "\n");
        _sBuild.append("Classification= " + this.get_classification() + "\n");
        _sBuild.append("Label= " + this.get_label() + "\n");
        return _sBuild.toString();
    }
}
