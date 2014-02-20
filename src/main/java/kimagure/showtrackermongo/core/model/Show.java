package kimagure.showtrackermongo.core.model;

import org.hibernate.validator.constraints.NotBlank;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/19/14
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Show {
    private String id = UUID.randomUUID().toString();

    @NotBlank
    private String title;

    private Integer episode;

    public Show() {
    }

    public Show(String title, Integer episode) {
        this.title = title;
        this.episode = episode;
    }

    public Show(String id, String title, Integer episode) {
        this.id = id;
        this.title = title;
        this.episode = episode;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getEpisode() {
        return episode;
    }
}
