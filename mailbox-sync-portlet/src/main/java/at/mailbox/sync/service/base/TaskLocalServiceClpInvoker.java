package at.mailbox.sync.service.base;

import at.mailbox.sync.service.TaskLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Claus Reitmeier
 * @generated
 */
public class TaskLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName40;
    private String[] _methodParameterTypes40;
    private String _methodName41;
    private String[] _methodParameterTypes41;
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;
    private String _methodName48;
    private String[] _methodParameterTypes48;
    private String _methodName49;
    private String[] _methodParameterTypes49;
    private String _methodName50;
    private String[] _methodParameterTypes50;
    private String _methodName51;
    private String[] _methodParameterTypes51;
    private String _methodName52;
    private String[] _methodParameterTypes52;

    public TaskLocalServiceClpInvoker() {
        _methodName0 = "addTask";

        _methodParameterTypes0 = new String[] { "at.mailbox.sync.model.Task" };

        _methodName1 = "createTask";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteTask";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteTask";

        _methodParameterTypes3 = new String[] { "at.mailbox.sync.model.Task" };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchTask";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getTask";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getTasks";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getTasksCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateTask";

        _methodParameterTypes15 = new String[] { "at.mailbox.sync.model.Task" };

        _methodName40 = "getBeanIdentifier";

        _methodParameterTypes40 = new String[] {  };

        _methodName41 = "setBeanIdentifier";

        _methodParameterTypes41 = new String[] { "java.lang.String" };

        _methodName46 = "addTask";

        _methodParameterTypes46 = new String[] {  };

        _methodName47 = "addTask";

        _methodParameterTypes47 = new String[] {
                "long", "long", "java.lang.String", "java.lang.Long",
                "java.lang.Long", "java.lang.Long", "java.lang.Long",
                "java.lang.Long", "java.lang.Long", "java.lang.Long",
                "java.lang.String", "java.lang.Integer",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName48 = "deleteTask";

        _methodParameterTypes48 = new String[] { "at.mailbox.sync.model.Task" };

        _methodName49 = "deleteTask";

        _methodParameterTypes49 = new String[] { "long" };

        _methodName50 = "getTaskByMailboxId";

        _methodParameterTypes50 = new String[] { "long", "java.lang.String" };

        _methodName51 = "updateTask";

        _methodParameterTypes51 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String",
                "java.lang.Long", "java.lang.Long", "java.lang.Long",
                "java.lang.Long", "java.lang.Long", "java.lang.Long",
                "java.lang.Long", "java.lang.String", "java.lang.Integer",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName52 = "getTaskByGroupId";

        _methodParameterTypes52 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return TaskLocalServiceUtil.addTask((at.mailbox.sync.model.Task) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return TaskLocalServiceUtil.createTask(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return TaskLocalServiceUtil.deleteTask(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return TaskLocalServiceUtil.deleteTask((at.mailbox.sync.model.Task) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return TaskLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return TaskLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return TaskLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return TaskLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return TaskLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return TaskLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return TaskLocalServiceUtil.fetchTask(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return TaskLocalServiceUtil.getTask(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return TaskLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return TaskLocalServiceUtil.getTasks(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return TaskLocalServiceUtil.getTasksCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return TaskLocalServiceUtil.updateTask((at.mailbox.sync.model.Task) arguments[0]);
        }

        if (_methodName40.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
            return TaskLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName41.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
            TaskLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return TaskLocalServiceUtil.addTask();
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            return TaskLocalServiceUtil.addTask(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2], (java.lang.Long) arguments[3],
                (java.lang.Long) arguments[4], (java.lang.Long) arguments[5],
                (java.lang.Long) arguments[6], (java.lang.Long) arguments[7],
                (java.lang.Long) arguments[8], (java.lang.Long) arguments[9],
                (java.lang.String) arguments[10],
                (java.lang.Integer) arguments[11],
                (com.liferay.portal.service.ServiceContext) arguments[12]);
        }

        if (_methodName48.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
            return TaskLocalServiceUtil.deleteTask((at.mailbox.sync.model.Task) arguments[0]);
        }

        if (_methodName49.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
            return TaskLocalServiceUtil.deleteTask(((Long) arguments[0]).longValue());
        }

        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return TaskLocalServiceUtil.getTaskByMailboxId(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            return TaskLocalServiceUtil.updateTask(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3], (java.lang.Long) arguments[4],
                (java.lang.Long) arguments[5], (java.lang.Long) arguments[6],
                (java.lang.Long) arguments[7], (java.lang.Long) arguments[8],
                (java.lang.Long) arguments[9], (java.lang.Long) arguments[10],
                (java.lang.String) arguments[11],
                (java.lang.Integer) arguments[12],
                (com.liferay.portal.service.ServiceContext) arguments[13]);
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return TaskLocalServiceUtil.getTaskByGroupId(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
