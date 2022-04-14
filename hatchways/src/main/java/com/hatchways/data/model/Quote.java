package com.hatchways.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

        private String type;
        private Valuey valuey;

        public Quote() {

        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Valuey getValue() {
            return valuey;
        }

        public void setValue(Valuey valuey) {
            this.valuey = valuey;
        }

        @Override
        public String toString() {
            return "Quote{" +
                    "type='" + type + '\'' +
                    ", value=" + valuey +
                    '}';
        }

}
