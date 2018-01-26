/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  h.ono
 * Created: 2018/01/19
 */

create table todo (
  id serial
  , task text not null
  , expire_date date
  , status char(1) not null
  , priority char(1)
  , create_date timestamp
  , update_dapte timestamp
  , constraint todo_PKC primary key (id)
) ;