FROM osixia/openldap
ENV LDAP_ORGANISATION="ulearn"
ENV LDAP_DOMAIN="ulearn.com"
COPY bootstrap.ldif /container/service/slapd/assests/config/bootstrap/ldif/50-bootstrap.ldif
EXPOSE 389
EXPOSE 636