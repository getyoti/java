package com.yoti.api.client.docs.session.retrieve;

import java.util.List;

public interface CheckResponse {

    /**
     * The ID of the check
     *
     * @return the ID
     */
    String getId();

    /**
     * The state of the check
     *
     * @return the state
     */
    String getState();

    /**
     * The resources used by the check
     *
     * @return the resources used
     */
    List<String> getResourcesUsed();

    /**
     * The media generated by the check
     *
     * @return the generated media
     */
    List<? extends GeneratedMedia> getGeneratedMedia();

    /**
     * The report associated with the check
     *
     * @return the report
     */
    ReportResponse getReport();

    /**
     * Date string for the created date of the check
     *
     * @return created date string
     */
    String getCreated();

    /**
     * Date string for the last updated date of the check
     *
     * @return last updated date string
     */
    String getLastUpdated();

}
