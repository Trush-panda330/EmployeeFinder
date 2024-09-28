<%@ page language="java" contentType="text/html;
 charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>社員表画面</title>
    <style>
      table,
      th,
      td {
        border: solid 1px;
        width: 400px;
        padding: 2px;
        text-align: center;
      }
    </style>
  </head>
  <body>
    <table>
      <caption>
        社員表
      </caption>
      <tr bgcolor="#cccccc">
        <th>社員ID</th>
        <th>社員名</th>
        <th>部署名</th>
        <th>入社日</th>
      </tr>
      <tr>
        <td>0001</td>
        <td>佐藤</td>
        <td>技術</td>
        <td>2015/04/01</td>
      </tr>
    </table>
    <a href="javascript:history.back();">戻る</a>
  </body>
</html>
