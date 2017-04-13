create or replace package GetCentro
is
type tcursor is ref cursor;
procedure obtenerDatosCentro (nombreC in varchar,datos out tcursor);
procedure obtenerDatosCentroXid (idC in number,datos out tcursor);
procedure obtenerTodosLosCentros (datos out tcursor);
end;