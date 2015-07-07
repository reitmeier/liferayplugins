# Mailbox Sync Portlet


## Source Code
File->Import->Maven->Existing Maven Projects

Select Root Folder liferayplugins

Select all projects

If you want to regenenerate the Service Builder code execute the maven goal "liferay:build-service" on project mailbox-sync-service.

´To deploy the portlet in Eclipse just add the projekt "mailbox-sync-portlet" to the Liferay Server in the 'Server' view.

If you work with eclipse behind a proxy define your proxy within setting.xml or use this example:
 Eclipse\Window\Preferences\Maven\User Settings\User Settings: <your-dir>\liferayplugins\mailbox-sync\settings.xml 