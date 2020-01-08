package ru.epam.javacore.homework_12_dom.reporting;

import ru.epam.javacore.homework_12_dom.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
