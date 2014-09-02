(ns ilegra-library.db.schema
  (:require [clojure.java.jdbc :as sql]
            [noir.io :as io]))

(def db-store "site.db")

(def db-spec {:classname "org.h2.Driver"
              :subprotocol "h2"
              :subname (str (io/resource-path) db-store)
              :user "sa"
              :password ""
              :make-pool? true
              :naming {:keys clojure.string/lower-case
                       :fields clojure.string/upper-case}})
(defn initialized?
  "checks to see if the database schema is present"
  []
  (.exists (new java.io.File (str (io/resource-path) db-store ".mv.db"))))

(defn create-books-table []
  (sql/db-do-commands
    db-spec
    (sql/create-table-ddl
      :books
      [:id "INTEGER PRIMARY KEY AUTO_INCREMENT"]
      [:timestamp :timestamp]
      [:name "varchar(30)"]
      [:owner "varchar(200)"]))
  (sql/db-do-prepared db-spec
      "CREATE INDEX timestamp_index ON books (timestamp)"))

(defn create-tables
  "creates the database tables used by the application"
  []
  (create-books-table))
