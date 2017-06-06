package com.forum.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "channel")
public class Channel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "channel_id")
    private Integer channelId;

    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;

    @Size(min = 0, max = 255)
    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "date")
    private LocalDateTime date;

    public Channel() {
    }

    public Channel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Channel(Integer channelId, String name, String description) {
        this.channelId = channelId;
        this.name = name;
        this.description = description;
    }

    public Channel(Integer channelId, String name, String description, LocalDateTime date) {
        this.channelId = channelId;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Channel channel = (Channel) o;

        if (channelId != null ? !channelId.equals(channel.channelId) : channel.channelId != null) return false;
        if (name != null ? !name.equals(channel.name) : channel.name != null) return false;
        if (description != null ? !description.equals(channel.description) : channel.description != null) return false;
        return date != null ? date.equals(channel.date) : channel.date == null;
    }

    @Override
    public int hashCode() {
        int result = channelId != null ? channelId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelId=" + channelId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
