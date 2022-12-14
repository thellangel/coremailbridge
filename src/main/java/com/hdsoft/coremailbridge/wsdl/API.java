
package com.hdsoft.coremailbridge.wsdl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "API", targetNamespace = "http://coremail.cn/apiws")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface API {


    /**
     * 
     * @param domainName
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addDomain25", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddDomain25")
    @ResponseWrapper(localName = "addDomain25Response", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddDomain25Response")
    public ReturnInfo addDomain25(
        @WebParam(name = "domain_name", targetNamespace = "")
        String domainName);

    /**
     * 
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createObj", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.CreateObj")
    @ResponseWrapper(localName = "createObjResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.CreateObjResponse")
    public ReturnInfo createObj(
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param cosId
     * @param numOfClasses
     * @param orgId
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alterOrgCos", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AlterOrgCos")
    @ResponseWrapper(localName = "alterOrgCosResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AlterOrgCosResponse")
    public ReturnInfo alterOrgCos(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "cos_id", targetNamespace = "")
        int cosId,
        @WebParam(name = "num_of_classes", targetNamespace = "")
        int numOfClasses);

    /**
     * 
     * @param userAtDomain
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "userLogin", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.UserLogin")
    @ResponseWrapper(localName = "userLoginResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.UserLoginResponse")
    public ReturnInfo userLogin(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain);

    /**
     * 
     * @param userAtDomain
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "moveUser", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.MoveUser")
    @ResponseWrapper(localName = "moveUserResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.MoveUserResponse")
    public ReturnInfo moveUser(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param providerId
     * @param userId
     * @param orgId
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createUser", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.CreateUser")
    @ResponseWrapper(localName = "createUserResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.CreateUserResponse")
    public ReturnInfo createUser(
        @WebParam(name = "provider_id", targetNamespace = "")
        String providerId,
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "user_id", targetNamespace = "")
        String userId,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param userAtDomain
     * @param aliasUserAtDomain
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addSmtpAlias", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddSmtpAlias")
    @ResponseWrapper(localName = "addSmtpAliasResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddSmtpAliasResponse")
    public ReturnInfo addSmtpAlias(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain,
        @WebParam(name = "alias_user_at_domain", targetNamespace = "")
        String aliasUserAtDomain);

    /**
     * 
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDomainList", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetDomainList")
    @ResponseWrapper(localName = "getDomainListResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetDomainListResponse")
    public ReturnInfo getDomainList();

    /**
     * 
     * @param objUid
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "setObjAttrs", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SetObjAttrs")
    @ResponseWrapper(localName = "setObjAttrsResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SetObjAttrsResponse")
    public ReturnInfo setObjAttrs(
        @WebParam(name = "obj_uid", targetNamespace = "")
        String objUid,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param userAtDomain
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "changeAttrs", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.ChangeAttrs")
    @ResponseWrapper(localName = "changeAttrsResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.ChangeAttrsResponse")
    public ReturnInfo changeAttrs(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param sesId
     * @param sesKey
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSessionVar", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetSessionVar")
    @ResponseWrapper(localName = "getSessionVarResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetSessionVarResponse")
    public ReturnInfo getSessionVar(
        @WebParam(name = "ses_id", targetNamespace = "")
        String sesId,
        @WebParam(name = "ses_key", targetNamespace = "")
        String sesKey);

    /**
     * 
     * @param userAtDomain
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "setAdminType", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SetAdminType")
    @ResponseWrapper(localName = "setAdminTypeResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SetAdminTypeResponse")
    public ReturnInfo setAdminType(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain);

    /**
     * 
     * @param domainName
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "delDomain25", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DelDomain25")
    @ResponseWrapper(localName = "delDomain25Response", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DelDomain25Response")
    public ReturnInfo delDomain25(
        @WebParam(name = "domain_name", targetNamespace = "")
        String domainName);

    /**
     * 
     * @param orgUnitId
     * @param orgId
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUnitAttrs", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetUnitAttrs")
    @ResponseWrapper(localName = "getUnitAttrsResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetUnitAttrsResponse")
    public ReturnInfo getUnitAttrs(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "org_unit_id", targetNamespace = "")
        String orgUnitId,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param domainName
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDomainAlias", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetDomainAlias")
    @ResponseWrapper(localName = "getDomainAliasResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetDomainAliasResponse")
    public ReturnInfo getDomainAlias(
        @WebParam(name = "domain_name", targetNamespace = "")
        String domainName);

    /**
     * 
     * @param objUid
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteObj", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DeleteObj")
    @ResponseWrapper(localName = "deleteObjResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DeleteObjResponse")
    public ReturnInfo deleteObj(
        @WebParam(name = "obj_uid", targetNamespace = "")
        String objUid);

    /**
     * 
     * @param sesId
     * @param sesKey
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSesssionVar", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetSesssionVar")
    @ResponseWrapper(localName = "getSesssionVarResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetSesssionVarResponse")
    public ReturnInfo getSesssionVar(
        @WebParam(name = "ses_id", targetNamespace = "")
        String sesId,
        @WebParam(name = "ses_key", targetNamespace = "")
        String sesKey);

    /**
     * 
     * @param domainName
     * @param domainNameAlias
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "delDomainAlias", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DelDomainAlias")
    @ResponseWrapper(localName = "delDomainAliasResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DelDomainAliasResponse")
    public ReturnInfo delDomainAlias(
        @WebParam(name = "domain_name", targetNamespace = "")
        String domainName,
        @WebParam(name = "domain_name_alias", targetNamespace = "")
        String domainNameAlias);

    /**
     * 
     * @param domainName
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "domainExist", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DomainExist")
    @ResponseWrapper(localName = "domainExistResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DomainExistResponse")
    public ReturnInfo domainExist(
        @WebParam(name = "domain_name", targetNamespace = "")
        String domainName);

    /**
     * 
     * @param userAtDomain
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "userLoginEx", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.UserLoginEx")
    @ResponseWrapper(localName = "userLoginExResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.UserLoginExResponse")
    public ReturnInfo userLoginEx(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param orgId
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alterOrg", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AlterOrg")
    @ResponseWrapper(localName = "alterOrgResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AlterOrgResponse")
    public ReturnInfo alterOrg(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param userAtDomain
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAttrs", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetAttrs")
    @ResponseWrapper(localName = "getAttrsResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetAttrsResponse")
    public ReturnInfo getAttrs(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param domainName
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOrgListByDomain", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetOrgListByDomain")
    @ResponseWrapper(localName = "getOrgListByDomainResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetOrgListByDomainResponse")
    public ReturnInfo getOrgListByDomain(
        @WebParam(name = "domain_name", targetNamespace = "")
        String domainName);

    /**
     * 
     * @param cmd
     * @param params
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "submit", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.Submit")
    @ResponseWrapper(localName = "submitResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SubmitResponse")
    public ReturnInfo submit(
        @WebParam(name = "cmd", targetNamespace = "")
        int cmd,
        @WebParam(name = "params", targetNamespace = "")
        String params,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param password
     * @param userAtDomain
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "authenticate", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.Authenticate")
    @ResponseWrapper(localName = "authenticateResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AuthenticateResponse")
    public ReturnInfo authenticate(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param sesVar
     * @param sesId
     * @param sesKey
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "setSessionVar", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SetSessionVar")
    @ResponseWrapper(localName = "setSessionVarResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SetSessionVarResponse")
    public ReturnInfo setSessionVar(
        @WebParam(name = "ses_id", targetNamespace = "")
        String sesId,
        @WebParam(name = "ses_key", targetNamespace = "")
        String sesKey,
        @WebParam(name = "ses_var", targetNamespace = "")
        String sesVar);

    /**
     * 
     * @param newUserId
     * @param userAtDomain
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "renameUser", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.RenameUser")
    @ResponseWrapper(localName = "renameUserResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.RenameUserResponse")
    public ReturnInfo renameUser(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain,
        @WebParam(name = "new_user_id", targetNamespace = "")
        String newUserId);

    /**
     * 
     * @param orgUnitId
     * @param orgId
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addUnit", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddUnit")
    @ResponseWrapper(localName = "addUnitResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddUnitResponse")
    public ReturnInfo addUnit(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "org_unit_id", targetNamespace = "")
        String orgUnitId,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param orgUnitId
     * @param orgId
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "delUnit", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DelUnit")
    @ResponseWrapper(localName = "delUnitResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DelUnitResponse")
    public ReturnInfo delUnit(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "org_unit_id", targetNamespace = "")
        String orgUnitId);

    /**
     * 
     * @param userAtDomain
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAdminType", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetAdminType")
    @ResponseWrapper(localName = "getAdminTypeResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetAdminTypeResponse")
    public ReturnInfo getAdminType(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain);

    /**
     * 
     * @param orgUnitId
     * @param orgId
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "setUnitAttrs", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SetUnitAttrs")
    @ResponseWrapper(localName = "setUnitAttrsResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SetUnitAttrsResponse")
    public ReturnInfo setUnitAttrs(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "org_unit_id", targetNamespace = "")
        String orgUnitId,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param cosId
     * @param orgId
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOrgCosUser", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetOrgCosUser")
    @ResponseWrapper(localName = "getOrgCosUserResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetOrgCosUserResponse")
    public ReturnInfo getOrgCosUser(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "cos_id", targetNamespace = "")
        int cosId);

    /**
     * 
     * @param orgId
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addOrg", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddOrg")
    @ResponseWrapper(localName = "addOrgResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddOrgResponse")
    public ReturnInfo addOrg(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param sesId
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sesRefresh", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SesRefresh")
    @ResponseWrapper(localName = "sesRefreshResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SesRefreshResponse")
    public ReturnInfo sesRefresh(
        @WebParam(name = "ses_id", targetNamespace = "")
        String sesId);

    /**
     * 
     * @param cmd
     * @param params
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "submitJSON", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SubmitJSON")
    @ResponseWrapper(localName = "submitJSONResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SubmitJSONResponse")
    public ReturnInfo submitJSON(
        @WebParam(name = "cmd", targetNamespace = "")
        int cmd,
        @WebParam(name = "params", targetNamespace = "")
        String params);

    /**
     * 
     * @param userAtDomain
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "userExist", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.UserExist")
    @ResponseWrapper(localName = "userExistResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.UserExistResponse")
    public ReturnInfo userExist(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain);

    /**
     * 
     * @param userAtDomain
     * @param options
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getNewMailInfos", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetNewMailInfos")
    @ResponseWrapper(localName = "getNewMailInfosResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetNewMailInfosResponse")
    public ReturnInfo getNewMailInfos(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain,
        @WebParam(name = "options", targetNamespace = "")
        String options);

    /**
     * 
     * @param userAtDomain
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteUser", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DeleteUser")
    @ResponseWrapper(localName = "deleteUserResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DeleteUserResponse")
    public ReturnInfo deleteUser(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain);

    /**
     * 
     * @param userAtDomain
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSmtpAlias", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetSmtpAlias")
    @ResponseWrapper(localName = "getSmtpAliasResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetSmtpAliasResponse")
    public ReturnInfo getSmtpAlias(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain);

    /**
     * 
     * @param cosId
     * @param orgId
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOrgCosUserMax", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetOrgCosUserMax")
    @ResponseWrapper(localName = "getOrgCosUserMaxResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetOrgCosUserMaxResponse")
    public ReturnInfo getOrgCosUserMax(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "cos_id", targetNamespace = "")
        int cosId);

    /**
     * 
     * @param userAtDomain
     * @param aliasUserAtDomain
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "delSmtpAlias", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DelSmtpAlias")
    @ResponseWrapper(localName = "delSmtpAliasResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DelSmtpAliasResponse")
    public ReturnInfo delSmtpAlias(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain,
        @WebParam(name = "alias_user_at_domain", targetNamespace = "")
        String aliasUserAtDomain);

    /**
     * 
     * @param sesId
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sesTimeOut", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SesTimeOut")
    @ResponseWrapper(localName = "sesTimeOutResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SesTimeOutResponse")
    public ReturnInfo sesTimeOut(
        @WebParam(name = "ses_id", targetNamespace = "")
        String sesId);

    /**
     * 
     * @param objUid
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getObjAttrs", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetObjAttrs")
    @ResponseWrapper(localName = "getObjAttrsResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetObjAttrsResponse")
    public ReturnInfo getObjAttrs(
        @WebParam(name = "obj_uid", targetNamespace = "")
        String objUid,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

    /**
     * 
     * @param cosId
     * @param orgId
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "delOrgCos", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DelOrgCos")
    @ResponseWrapper(localName = "delOrgCosResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DelOrgCosResponse")
    public ReturnInfo delOrgCos(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "cos_id", targetNamespace = "")
        int cosId);

    /**
     * 
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOrgList", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetOrgList")
    @ResponseWrapper(localName = "getOrgListResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetOrgListResponse")
    public ReturnInfo getOrgList();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getVersionInfo", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetVersionInfo")
    @ResponseWrapper(localName = "getVersionInfoResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetVersionInfoResponse")
    public String getVersionInfo();

    /**
     * 
     * @param domainName
     * @param orgId
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addOrgDomain", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddOrgDomain")
    @ResponseWrapper(localName = "addOrgDomainResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddOrgDomainResponse")
    public ReturnInfo addOrgDomain(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "domain_name", targetNamespace = "")
        String domainName);

    /**
     * 
     * @param cosId
     * @param numOfClasses
     * @param orgId
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addOrgCos", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddOrgCos")
    @ResponseWrapper(localName = "addOrgCosResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddOrgCosResponse")
    public ReturnInfo addOrgCos(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "cos_id", targetNamespace = "")
        int cosId,
        @WebParam(name = "num_of_classes", targetNamespace = "")
        int numOfClasses);

    /**
     * 
     * @param userAtDomain
     * @param options
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listMailInfos", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.ListMailInfos")
    @ResponseWrapper(localName = "listMailInfosResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.ListMailInfosResponse")
    public ReturnInfo listMailInfos(
        @WebParam(name = "user_at_domain", targetNamespace = "")
        String userAtDomain,
        @WebParam(name = "options", targetNamespace = "")
        String options);

    /**
     * 
     * @param sesId
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "userLogout", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.UserLogout")
    @ResponseWrapper(localName = "userLogoutResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.UserLogoutResponse")
    public ReturnInfo userLogout(
        @WebParam(name = "ses_id", targetNamespace = "")
        String sesId);

    /**
     * 
     * @param domainName
     * @param domainNameAlias
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addDomainAlias", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddDomainAlias")
    @ResponseWrapper(localName = "addDomainAliasResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.AddDomainAliasResponse")
    public ReturnInfo addDomainAlias(
        @WebParam(name = "domain_name", targetNamespace = "")
        String domainName,
        @WebParam(name = "domain_name_alias", targetNamespace = "")
        String domainNameAlias);

    /**
     * 
     * @param rcptTo
     * @param data
     * @param options
     * @param mailFrom
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "smtpTransport", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SmtpTransport")
    @ResponseWrapper(localName = "smtpTransportResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.SmtpTransportResponse")
    public ReturnInfo smtpTransport(
        @WebParam(name = "mail_from", targetNamespace = "")
        String mailFrom,
        @WebParam(name = "rcpt_to", targetNamespace = "")
        String rcptTo,
        @WebParam(name = "data", targetNamespace = "")
        String data,
        @WebParam(name = "options", targetNamespace = "")
        String options);

    /**
     * 
     * @param domainName
     * @param orgId
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "delOrgDomain", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DelOrgDomain")
    @ResponseWrapper(localName = "delOrgDomainResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.DelOrgDomainResponse")
    public ReturnInfo delOrgDomain(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "domain_name", targetNamespace = "")
        String domainName);

    /**
     * 
     * @param orgId
     * @param attrs
     * @return
     *     returns com.hdsoft.coremailbridge.wsdl.ReturnInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOrgInfo", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetOrgInfo")
    @ResponseWrapper(localName = "getOrgInfoResponse", targetNamespace = "http://coremail.cn/apiws", className = "com.hdsoft.coremailbridge.wsdl.GetOrgInfoResponse")
    public ReturnInfo getOrgInfo(
        @WebParam(name = "org_id", targetNamespace = "")
        String orgId,
        @WebParam(name = "attrs", targetNamespace = "")
        String attrs);

}
