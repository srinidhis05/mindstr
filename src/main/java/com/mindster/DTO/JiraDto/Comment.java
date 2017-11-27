package com.mindster.DTO.JiraDto;

/**
 * Created by shreyas on 17/12/16.
 */
public class Comment {
    private String id;

    private String body;

    private People author;

    private String updated;

    private String created;

    private People updateAuthor;

    private String self;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getBody ()
    {
        return body;
    }

    public void setBody (String body)
    {
        this.body = body;
    }

    public People getAuthor ()
    {
        return author;
    }

    public void setAuthor (People author)
    {
        this.author = author;
    }

    public String getUpdated ()
    {
        return updated;
    }

    public void setUpdated (String updated)
    {
        this.updated = updated;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public People getUpdateAuthor ()
    {
        return updateAuthor;
    }

    public void setUpdateAuthor (People updateAuthor)
    {
        this.updateAuthor = updateAuthor;
    }

    public String getSelf ()
    {
        return self;
    }

    public void setSelf (String self)
    {
        this.self = self;
    }


    @Override
    public String toString(){
        return "id:"+id+
                ",body:"+body+
                ",author:{"+author.toString()+"}"+
                ",updated:"+updated+
                ",created:"+created+
                ",updateAuthor:{"+updateAuthor.toString()+"}"+
                ",self:"+self;
    }
}
