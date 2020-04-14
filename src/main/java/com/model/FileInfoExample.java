package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public FileInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("file_path is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("file_path is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("file_path =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("file_path <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("file_path >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_path >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("file_path <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("file_path <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("file_path like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("file_path not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("file_path in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("file_path not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("file_path between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("file_path not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFileSaveIsNull() {
            addCriterion("file_save is null");
            return (Criteria) this;
        }

        public Criteria andFileSaveIsNotNull() {
            addCriterion("file_save is not null");
            return (Criteria) this;
        }

        public Criteria andFileSaveEqualTo(String value) {
            addCriterion("file_save =", value, "fileSave");
            return (Criteria) this;
        }

        public Criteria andFileSaveNotEqualTo(String value) {
            addCriterion("file_save <>", value, "fileSave");
            return (Criteria) this;
        }

        public Criteria andFileSaveGreaterThan(String value) {
            addCriterion("file_save >", value, "fileSave");
            return (Criteria) this;
        }

        public Criteria andFileSaveGreaterThanOrEqualTo(String value) {
            addCriterion("file_save >=", value, "fileSave");
            return (Criteria) this;
        }

        public Criteria andFileSaveLessThan(String value) {
            addCriterion("file_save <", value, "fileSave");
            return (Criteria) this;
        }

        public Criteria andFileSaveLessThanOrEqualTo(String value) {
            addCriterion("file_save <=", value, "fileSave");
            return (Criteria) this;
        }

        public Criteria andFileSaveLike(String value) {
            addCriterion("file_save like", value, "fileSave");
            return (Criteria) this;
        }

        public Criteria andFileSaveNotLike(String value) {
            addCriterion("file_save not like", value, "fileSave");
            return (Criteria) this;
        }

        public Criteria andFileSaveIn(List<String> values) {
            addCriterion("file_save in", values, "fileSave");
            return (Criteria) this;
        }

        public Criteria andFileSaveNotIn(List<String> values) {
            addCriterion("file_save not in", values, "fileSave");
            return (Criteria) this;
        }

        public Criteria andFileSaveBetween(String value1, String value2) {
            addCriterion("file_save between", value1, value2, "fileSave");
            return (Criteria) this;
        }

        public Criteria andFileSaveNotBetween(String value1, String value2) {
            addCriterion("file_save not between", value1, value2, "fileSave");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("file_type like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(Integer value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(Integer value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(Integer value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(Integer value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(Integer value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<Integer> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<Integer> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(Integer value1, Integer value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileDetailIsNull() {
            addCriterion("file_detail is null");
            return (Criteria) this;
        }

        public Criteria andFileDetailIsNotNull() {
            addCriterion("file_detail is not null");
            return (Criteria) this;
        }

        public Criteria andFileDetailEqualTo(String value) {
            addCriterion("file_detail =", value, "fileDetail");
            return (Criteria) this;
        }

        public Criteria andFileDetailNotEqualTo(String value) {
            addCriterion("file_detail <>", value, "fileDetail");
            return (Criteria) this;
        }

        public Criteria andFileDetailGreaterThan(String value) {
            addCriterion("file_detail >", value, "fileDetail");
            return (Criteria) this;
        }

        public Criteria andFileDetailGreaterThanOrEqualTo(String value) {
            addCriterion("file_detail >=", value, "fileDetail");
            return (Criteria) this;
        }

        public Criteria andFileDetailLessThan(String value) {
            addCriterion("file_detail <", value, "fileDetail");
            return (Criteria) this;
        }

        public Criteria andFileDetailLessThanOrEqualTo(String value) {
            addCriterion("file_detail <=", value, "fileDetail");
            return (Criteria) this;
        }

        public Criteria andFileDetailLike(String value) {
            addCriterion("file_detail like", value, "fileDetail");
            return (Criteria) this;
        }

        public Criteria andFileDetailNotLike(String value) {
            addCriterion("file_detail not like", value, "fileDetail");
            return (Criteria) this;
        }

        public Criteria andFileDetailIn(List<String> values) {
            addCriterion("file_detail in", values, "fileDetail");
            return (Criteria) this;
        }

        public Criteria andFileDetailNotIn(List<String> values) {
            addCriterion("file_detail not in", values, "fileDetail");
            return (Criteria) this;
        }

        public Criteria andFileDetailBetween(String value1, String value2) {
            addCriterion("file_detail between", value1, value2, "fileDetail");
            return (Criteria) this;
        }

        public Criteria andFileDetailNotBetween(String value1, String value2) {
            addCriterion("file_detail not between", value1, value2, "fileDetail");
            return (Criteria) this;
        }

        public Criteria andFileUploadIsNull() {
            addCriterion("file_upload is null");
            return (Criteria) this;
        }

        public Criteria andFileUploadIsNotNull() {
            addCriterion("file_upload is not null");
            return (Criteria) this;
        }

        public Criteria andFileUploadEqualTo(Date value) {
            addCriterion("file_upload =", value, "fileUpload");
            return (Criteria) this;
        }

        public Criteria andFileUploadNotEqualTo(Date value) {
            addCriterion("file_upload <>", value, "fileUpload");
            return (Criteria) this;
        }

        public Criteria andFileUploadGreaterThan(Date value) {
            addCriterion("file_upload >", value, "fileUpload");
            return (Criteria) this;
        }

        public Criteria andFileUploadGreaterThanOrEqualTo(Date value) {
            addCriterion("file_upload >=", value, "fileUpload");
            return (Criteria) this;
        }

        public Criteria andFileUploadLessThan(Date value) {
            addCriterion("file_upload <", value, "fileUpload");
            return (Criteria) this;
        }

        public Criteria andFileUploadLessThanOrEqualTo(Date value) {
            addCriterion("file_upload <=", value, "fileUpload");
            return (Criteria) this;
        }

        public Criteria andFileUploadIn(List<Date> values) {
            addCriterion("file_upload in", values, "fileUpload");
            return (Criteria) this;
        }

        public Criteria andFileUploadNotIn(List<Date> values) {
            addCriterion("file_upload not in", values, "fileUpload");
            return (Criteria) this;
        }

        public Criteria andFileUploadBetween(Date value1, Date value2) {
            addCriterion("file_upload between", value1, value2, "fileUpload");
            return (Criteria) this;
        }

        public Criteria andFileUploadNotBetween(Date value1, Date value2) {
            addCriterion("file_upload not between", value1, value2, "fileUpload");
            return (Criteria) this;
        }

        public Criteria andFileDownloadIsNull() {
            addCriterion("file_download is null");
            return (Criteria) this;
        }

        public Criteria andFileDownloadIsNotNull() {
            addCriterion("file_download is not null");
            return (Criteria) this;
        }

        public Criteria andFileDownloadEqualTo(Date value) {
            addCriterion("file_download =", value, "fileDownload");
            return (Criteria) this;
        }

        public Criteria andFileDownloadNotEqualTo(Date value) {
            addCriterion("file_download <>", value, "fileDownload");
            return (Criteria) this;
        }

        public Criteria andFileDownloadGreaterThan(Date value) {
            addCriterion("file_download >", value, "fileDownload");
            return (Criteria) this;
        }

        public Criteria andFileDownloadGreaterThanOrEqualTo(Date value) {
            addCriterion("file_download >=", value, "fileDownload");
            return (Criteria) this;
        }

        public Criteria andFileDownloadLessThan(Date value) {
            addCriterion("file_download <", value, "fileDownload");
            return (Criteria) this;
        }

        public Criteria andFileDownloadLessThanOrEqualTo(Date value) {
            addCriterion("file_download <=", value, "fileDownload");
            return (Criteria) this;
        }

        public Criteria andFileDownloadIn(List<Date> values) {
            addCriterion("file_download in", values, "fileDownload");
            return (Criteria) this;
        }

        public Criteria andFileDownloadNotIn(List<Date> values) {
            addCriterion("file_download not in", values, "fileDownload");
            return (Criteria) this;
        }

        public Criteria andFileDownloadBetween(Date value1, Date value2) {
            addCriterion("file_download between", value1, value2, "fileDownload");
            return (Criteria) this;
        }

        public Criteria andFileDownloadNotBetween(Date value1, Date value2) {
            addCriterion("file_download not between", value1, value2, "fileDownload");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}