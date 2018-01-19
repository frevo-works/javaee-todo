/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.frevoworks.javaee.todo.domain.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author h.ono
 */
@Entity
@Table(name = "todo")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
@NamedQueries({
    @NamedQuery(name = "Todo.findAll", query = "SELECT t FROM Todo t")
    , @NamedQuery(name = "Todo.findById", query = "SELECT t FROM Todo t WHERE t.id = :id")
    , @NamedQuery(name = "Todo.findByTask", query = "SELECT t FROM Todo t WHERE t.task = :task")
    , @NamedQuery(name = "Todo.findByExpireDate", query = "SELECT t FROM Todo t WHERE t.expireDate = :expireDate")
    , @NamedQuery(name = "Todo.findByStatus", query = "SELECT t FROM Todo t WHERE t.status = :status")
    , @NamedQuery(name = "Todo.findByPriority", query = "SELECT t FROM Todo t WHERE t.priority = :priority")
    , @NamedQuery(name = "Todo.findByCreateDate", query = "SELECT t FROM Todo t WHERE t.createDate = :createDate")
    , @NamedQuery(name = "Todo.findByUpdateDate", query = "SELECT t FROM Todo t WHERE t.updateDate = :updateDate")
    , @NamedQuery(name = "Todo.findByDeleteDate", query = "SELECT t FROM Todo t WHERE t.deleteDate = :deleteDate")})
public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "task")
    private String task;
    @Size(max = 10)
    @Column(name = "expire_date")
    private String expireDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private String status;
    @Column(name = "priority")
    private String priority;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "delete_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteDate;

    public Todo(Integer id) {
        this.id = id;
    }
}
